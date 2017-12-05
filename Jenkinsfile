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
                sh 'mvn -Dmaven.test.failure.ignore=true install'
            }
        }
       
    }
    
}
