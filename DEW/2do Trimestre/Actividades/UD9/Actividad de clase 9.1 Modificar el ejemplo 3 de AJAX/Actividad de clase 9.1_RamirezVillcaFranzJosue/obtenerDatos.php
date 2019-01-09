<?php
$ar=fopen("votos.txt","r") or
  die("No se pudo abrir el archivo");
while (!feof($ar))
{
  $linea=fgets($ar);
  echo $linea;
}
fclose($ar);
?>