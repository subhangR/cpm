<h1>steps to run in local.</h1>

first time

    git clone https://github.com/subhangR/cpm.git
    git checkout -b master
    git pull origin master
    chmod 755 run.sh
    ./run.sh

<h3> Requirements </h3>

 you will need to set some environment variables for this to connect to postgres.


 if you have the free_instance_envs.txt you can use update your environment variables in intellij.
                                or
 you can use this command to apply the environment variables to your terminal.   
                            

    source free_instance_envs.txt 



<h1>Steps to run your in server</h1>
    after pushing the code to "my_branch" you can use these steps to run your code in aws.

    ssh -i playm8s.pem ubuntu@3.6.86.169
    cd cpm
    git checkout -b <my_branch>
    git pull origin <my_branch>
    ./run.sh
