#!/bin/bash

# installing dependencies
#echo "Installing dependencies . . . "
#sudo apt-get install texlive-base texlive-extra

# compiling source code
echo "Compiling source code . . ."
if [[ ! -d "classes" ]]; then
	mkdir classes
fi
javac -cp ./classes -d ./classes ./src/*.java
echo "Source code compiled."

echo "Creating executable . . ."
installation_path=$( pwd )
touch r.sh
class_path=$(realpath r.sh | sed 's/r.sh/classes/')
# writing code in resume-iitb.sh
echo '#!/bin/bash' >> r.sh
echo "java -cp $class_path Resume" >> r.sh
mv -f r.sh resume-iitb.sh

echo "Creating desktop shortcut . . ."

echo "Creating alias . . ."
if [[ ! -e ~/.bashrc ]]; then
	touch ~/.bashrc
fi
alias_present=$( grep "alias resume-iitb=\"bash $installation_path/resume-iitb.sh\"" ~/.bashrc | wc -l )
if [ $alias_present -eq 0 ]; then
	echo "alias resume-iitb=\"bash $installation_path/resume-iitb.sh\" " >> ~/.bashrc
fi

echo "Installation complete. You are ready to go."
echo "Type 'resume-iitb' to run the application. "
source ~/.bashrc

