#!/usr/bin/env groovy
pipeline {
    agent any
    stages {
        stage('clone stage') {
            steps {
                script {
                    git branch: 'main', url: 'https://github.com/HoussemSaafi/JenkinsTutorialProject.git'
                     echo "git repository cloned"
                }
            }
        }
        stage('show tree stage') {
                    steps {
                        echo "show local dir"
                        sh returnStatus: true, script: 'ls -l'
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
