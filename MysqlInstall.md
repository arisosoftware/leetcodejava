#Install mysql

sudo apt-get update
sudo apt-get install mysql-server
sudo ufw allow mysql
systemctl start mysql
systemctl enable mysql


#Start the mysql shell

/usr/bin/mysql -u root -p

#结果不行，为什么？
sudo apt-get purge mysql-server mysql-client mysql-common mysql-server-5.5
sudo apt-get install mysql-server
#还是不行！

systemctl status mysql 发现是 apparmor的 问题！

solution:
vi /etc/apparmor.d/usr.sbin.mysqld
加入：
# Allow services up
  /proc/*/status r,
  /sys/devices/system/node/ r,
  /sys/devices/system/node/node*/meminfo r,
#然后： reload apparmor service
 service apparmor reload
 systemctl start mysql


另外有人说，但我没有加也能成功启动mysql因此就不管它了。
Edit /etc/apparmor.d/local/usr.sbin.mysqld
/data/ r,
/data/** rwk,
reload apparmor service

#sudo service apparmor reload


## config git
### https://help.github.com/en/articles/caching-your-github-password-in-git
From the command line, change into the repository directory.
Set your username:
git config user.name "arisosoftware :)"
Set your email address:
git config user.email "arisosoftware@gmail.com"
Verify your configuration by displaying your configuration file:
cat .git/config

 git config --global credential.helper cache
git config --global credential.helper 'cache --timeout=360000'



reference:
https://support.rackspace.com/how-to/installing-mysql-server-on-ubuntu/
https://wiki.archlinux.org/index.php/AppArmor