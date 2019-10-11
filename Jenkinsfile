pipeline {
   agent any
   stages {
      stage("Checkout") {
         steps {
            git url: 'https://github.com/bengugit01/calculator.git'
         }
      }
      stage("Compile") {
         steps {
            sh "./gradlew compileJava"
         }
      }
      stage("Unit test") {
         steps {
            sh "./gradlew test"
         }
      }
      stage("Code coverage") {
         steps {
            sh "./gradlew jacocoTestReport"
            publishHTML (target: [
			   reportDir: 'build/reports/jacoco/test/html',
			   reportFiles: 'index.html',
			   reportName: "JaCoCo Report"
			])
            sh "./gradlew jacocoTestCoverageVerification"
         }
      }      
   }
}