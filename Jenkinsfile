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
//         stage('compile stage') {
//             steps {
//                 powershell 'javac *.java'
//                 echo "java files compiled"
//             }
//         }
        stage('run stage') {
            steps {
                powershell 'java -classpath C:\ProgramData\Jenkins\.jenkins\workspace\myFirstPipeline\out\production\JenkinsTutorialProject\td4\tp_parking td4.tp_parking.Main'
                echo "main application ran"
            }
        }
    }
}
