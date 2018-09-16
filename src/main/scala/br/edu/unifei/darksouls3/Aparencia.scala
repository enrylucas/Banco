package br.edu.unifei.darksouls3

import scala.slick.driver.PostgresDriver.simple._

class Aparencia(tag: Tag) extends Table[(Int,String,String,String,String,String,Float,String)](tag,"aparencia"){
  def idVisual = column[Int]("idVisual",O.PrimaryKey)
  def cabelo = column[String]("cabelo")
  def cabeloCor = column[String]("cabeloCor")
  def olho = column[String]("olho")
  def olhoCor = column[String]("olhoCor")
  def genero = column[String]("genero")
  def altura = column[Float]("altura")
  def peleCor = column[String]("peleCor")

  def * = (idVisual,cabelo,cabeloCor,olho,olhoCor,genero,altura,peleCor)
}
