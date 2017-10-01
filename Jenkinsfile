pipeline {
    agent any
    tools {
        maven 
        jdk
    }
    stages {
        stage ('Initialize') {
            steps {

            }
        }

        stage ('Build') {
            steps {
                sh 'mvn -Dmaven.test.failure.ignore=true install' 
            }
            post {
                success {
                    junit 'target/surefire-reports/**/*.xml' 
                }
            }
        }
    }
}
