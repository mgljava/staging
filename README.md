# staging Continuous Integration(CI)
1. add githooks
   * 复制一份文件到config目录
   * 在gradle文件中加入
   ```
   copy {
       from "./config/githooks/"
       into "./.git/hooks/"
       fileMode 0755
   }
   ```
2. integration jacoco(以下操作都是build.gradle中)
   1. 加入jacoco：`apply plugin: "jacoco"`
   
   2. 写task:jacocoTestReport
   ```
   jacocoTestReport {
       reports {
           html.enabled true
           xml.enabled false
           csv.enabled false
       }
       afterEvaluate {
           classDirectories = files(classDirectories.files.collect {
               fileTree(
                       dir: it,
                       exclude: [
                               '**/StagingApplication.class'
                       ]
               )
           })
       }
   }
   ```
   
   3.写task:jacocoTestCoverageVerification 此处会依赖jacocoTestReport
   ```
   jacocoTestCoverageVerification {
       violationRules {
           rule {
               element = 'CLASS'
               excludes = [
                       '**.StagingApplication'
               ]
   
               limit {
                   counter = 'LINE'
                   value = 'COVEREDRATIO'
                   minimum = 0.8
               }
               limit {
                   counter = 'BRANCH'
                   value = 'COVEREDRATIO'
                   minimum = 0.8
               }
               limit {
                   counter = 'METHOD'
                   value = 'COVEREDRATIO'
                   minimum = 0.8
               }
               limit {
                   counter = 'CLASS'
                   value = 'COVEREDRATIO'
                   minimum = 0.8
               }
           }
       }
       dependsOn(jacocoTestReport)
   }
   ```
   
   4. 加入:`check.dependsOn jacocoTestCoverageVerification`
3. integration checkstyle
   1. 加入: `apply plugin: 'checkstyle'`
   2. 加入: checkstyle 
   ```
   checkstyle {
       toolVersion '8.1'
       ignoreFailures = false
       configFile file("$project.rootDir/config/checkstyle/checkstyle.xml")
       sourceSets = [sourceSets.main]
   
       checkstyleMain {
           source = 'src/main/java'
       }
   }
   ```
   
4. Jenkins & Sonar