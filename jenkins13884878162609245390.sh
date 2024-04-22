stages {
        stage('Prepare Workspace') {
            steps {
                echo 'Hello'
            }
        }
        stage('Git-Clone') {
            steps {
                echo "Git Clone stage"
                sh '''env | sort
                git clone ssh://git@xxxxx.yyyyy.zzzzz/tre/tre.git
                git clone ssh://git@xxxxx.yyyyy.zzzzz/tre/trux.git
                git clone ssh://git@xxxxx.yyyyy.zzzzz/tre/TREUnitTests.git
                '''
            }
        }
: