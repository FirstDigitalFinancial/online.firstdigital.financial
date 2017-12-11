pipeline {
    agent any
    
    environment {
        COVERALLS_REPO_TOKEN   = 'Qn8dMecfnfYCqIbIMo3fjUd125RWBegr9'
        COVERALLS_SERVICE_NAME = 'jenkins'
    }
    
    tools { 
        maven 'maven-3.5.2' 
        jdk 'jdk-8' 
    }
    
    stages {
        stage ('Initialize') {
            steps {
                try {
                    sh '''
                        echo "PATH = ${PATH}"
                        echo "M2_HOME = ${M2_HOME}"
                       '''
                       slackSend (color: '#FFFF00', message: "STARTED: Job '${env.JOB_NAME} [${env.BUILD_NUMBER}]' (${env.BUILD_URL})")
                   } catch (e) {
                        currentBuild.result = "FAILED"
                        slackSend (color: '#FF0000', message: "FAILED: Job '${env.JOB_NAME} [${env.BUILD_NUMBER}]' (${env.BUILD_URL})")
                        throw e
            }
            
        }
        
        stage ('Test') {
            steps {
                try {
                    sh 'mvn clean jacoco:prepare-agent test jacoco:report org.eluder.coveralls:coveralls-maven-plugin:report'
                } catch (e) {
                    currentBuild.result = "FAILED"
                    slackSend (color: '#FF0000', message: "FAILED: Job '${env.JOB_NAME} [${env.BUILD_NUMBER}]' (${env.BUILD_URL})")
                    throw e
                }
            }
        }
        
        stage ('Build') {
            steps {
                try {
                    sh 'mvn -Dmaven.test.failure.ignore=true install -Dbuild.number=${BUILD_NUMBER} -Dbuild.revision=${GIT_COMMIT}'
                    slackSend (color: '#00FF00', message: "SUCCESS: Job '${env.JOB_NAME} [${env.BUILD_NUMBER}]' (${env.BUILD_URL})")
                } catch (e) {
                    currentBuild.result = "FAILED"
                    slackSend (color: '#FF0000', message: "FAILED: Job '${env.JOB_NAME} [${env.BUILD_NUMBER}]' (${env.BUILD_URL})")
                    throw e
                }
            }
        }

        stage ('Publish to S3') {
            steps{
                step([
                    $class: 'S3BucketPublisher',
                    entries: [[
                        sourceFile: 'target/online.firstdigital.financial-1.0.build-${BUILD_NUMBER}.jar',
                        bucket: 'artifacts.firstdigital.financial',
                        selectedRegion: 'eu-west-1',
                        noUploadOnFailure: true,
                        managedArtifacts: false,
                        flatten: true,
                        showDirectlyInBrowser: true,
                        keepForever: true,
                    ]],
                    profileName: 'artifacts.firstdigital.financial',
                    dontWaitForConcurrentBuildCompletion: false,
                ])
            }
        }
       
    }
    
}
