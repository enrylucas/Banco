package br.edu.unifei.darksouls3

import scala.slick.driver.PostgresDriver.simple._

class Ser(tag: Tag) extends Table[(String,Int,Int,Int,Long,String,Boolean,Int,Int,Int,Int,Float)](tag, "ser") {
  //def id = column[Int]("id")
  def nome = column[String]("nome",O.PrimaryKey)
  def vida = column[Int]("vida")
  def foco = column[Int]("foco")
  def estamina = column[Int]("estamina")
  def almas = column[Long]("almas")
  def especie = column[String]("especie")
  def hollow = column[Boolean]("hollow")
  def forca = column[Int]("forca")
  def destreza = column[Int]("destreza")
  def inteligencia = column[Int]("inteligencia")
  def fe = column[Int]("fe")
  def defesaFisica = column[Float]("defesaFisica")
  def * = (nome,vida,foco,estamina,almas,especie,hollow,forca,destreza,inteligencia,fe,defesaFisica)
}
