# login automatically.
.ssh/authorized_keys

# putty
* generate a key pair with puttygen.exe (length: 1024 bits)
* load the private key in the PuTTY profile
* enter the public key in ~/.ssh/authorized_keys in one line (needs to start with ssh-rsa)
* chmod 700 ~/.ssh
* chmod 600 ~/.ssh/authorized_keys
* chown $USER:$USER ~/.ssh -R
* change /etc/ssh/sshd_config so it contains AuthorizedKeysFile %h/.ssh/authorized_keys
* sudo service ssh restart

* For troubleshooting do # tail -f /var/log/auth.log.

