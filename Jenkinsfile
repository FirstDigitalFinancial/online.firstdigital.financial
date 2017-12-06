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
                sh '''
                    echo "PATH = ${PATH}"
                    echo "M2_HOME = ${M2_HOME}"
                   ''' 
            }
            
        }
        
        stage ('Test') {
            steps {
                sh 'mvn clean jacoco:prepare-agent test jacoco:report org.eluder.coveralls:coveralls-maven-plugin:report'
            }
        }
        
        stage ('Build') {
            steps {
                sh '''
                    echo "Build Number: ${BUILD_NUMBER}"
                    echo "Build Revision: ${GIT_COMMIT}"
                   '''
                sh 'mvn -Dmaven.test.failure.ignore=true install -Dbuild.number=${BUILD_NUMBER} -Dbuild.revision=${GIT_COMMIT}'
            }
        }

        stage ('Publish to S3') {
            steps{
                step([
                    $class: 'S3BucketPublisher',
                    entries: [[
                        sourceFile: 'online.firstdigital.financial-1.0.${BUILD_NUMER}.${GIT_COMMIT}.jar',
                        bucket: 'artifacts.firstdigital.financial',
                        selectedRegion: 'eu-west-1',
                        noUploadOnFailure: true,
                        managedArtifacts: true,
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
