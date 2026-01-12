pipeline {
    agent any

    parameters {
        choice(
            name: 'TEST_SUITE',
            choices: ['testng_smoke.xml', 'testng_regression.xml', 'testng_e2e.xml'],
            description: 'Select TestNG suite to execute'
        )
    }

    stages {
        stage('Checkout Code') {
            steps {
                git 'https://github.com/iyoushhhhh/ecommerce-test-framework.git'
            }
        }

        stage('Run Tests') {
            steps {
                bat "mvn clean test -DsuiteXmlFile=${params.TEST_SUITE}"
            }
        }
    }

    post {
        always {
            publishHTML([
                reportDir: 'reports',
                reportFiles: 'ExtentReport.html',
                reportName: 'Automation Test Report'
            ])
        }
    }
}
