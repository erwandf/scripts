node {
   stage('Preparation') { // for display purposes
      // Get some code from a GitHub repository
      git 'https://github.com/sebastianbergmann/money.git'
   }
   stage('Tests') {
    sh 'php build/tools/phpunit.phar -c build/phpunit.xml'

    xunit (
        thresholds: [ skipped(failureThreshold: '0'), failed(failureThreshold: '0') ],
        tools: [ PHPUnit(pattern: 'build/logs/*.xml') ])
  }
}