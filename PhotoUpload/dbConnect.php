<?php
 //###################CONEXAO COM O BANCO DE DADOS, MYSQL#############################
//REALIZA A CONEXÃO COM O BANCO DE DADOS, MYSQL.
//PASSAMOS PARA ESSA CONEXÃO O LOCAL DO BANCO, O USUÁRIO E A SENHA.
$con=mysql_connect('localhost','root','bcd127');
//ESPECIFICAMOS O DATABASE A SER UTILIZADO.
mysql_select_db('dbUploadFoto');
 
 ?>