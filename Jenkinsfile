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
      stage("Static code analysis") {
	     steps {
	        sh "./gradlew checkstyleMain"
	        publishHTML (target: [
			   reportDir: 'build/reports/checkstyle/',
			   reportFiles: 'main.html',
			   reportName: "Checkstyle Report"
			])
	     }
      }
      stage("Package") {
         steps {
            sh "./gradlew build"
         }
      }
      stage("Docker build") {
         steps {
            sh "docker build -t bengu/calculator ."
         }
      }     
      stage("Docker push") {
	     steps {
            withCredentials([usernamePassword(credentialsId: 'dockerHub', passwordVariable: 'dockerHubPassword', usernameVariable: 'dockerHubUser')]) {
               sh "docker login -u ${env.dockerHubUser} -p ${env.dockerHubPassword}"
               sh "docker push bengu/calculator"
            }
         }
      }  
      stage("Deploy to staging") {
         steps {
            sh "docker run -v /var/run/docker.sock:/var/run/docker.sock -d --rm -p 8765:9091 --name calculator bengu/calculator"
         }
      }

      stage("Acceptance test") {
         steps {
              sleep 60
    		  sh "chmod +x acceptance-test.sh && ./acceptance-test.sh"
         }
      }         
   }
   
   post {
      always {
         sh "docker stop calculator"
      }
   }   
}