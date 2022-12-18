#!/usr/bin/env groovy
pipeline {
    agent any
    stages {
        stage('clone stage') {
            steps {
                script {
                    git branch: 'main', credentialsId: '54eb2fe9-b57b-4a5b-bc36-bc1c75156732', url: 'https://github.com/HoussemSaafi/JenkinsTutorialProject.git'
                     echo "git repository cloned"
                }
            }
        }
        stage('show tree stage') {
                    steps {
                        echo "show local dir"
                        sh 'ls -l'
                    }
        }
        stage('compile stage') {
            steps {
                sh returnStatus: true, script: 'javac *.java'
                echo "java files compiled"
            }
        }
        stage('run stage') {
            steps {
                sh returnStatus: true, script: 'java Main'
                echo "main application ran"
            }
        }
    }
}
