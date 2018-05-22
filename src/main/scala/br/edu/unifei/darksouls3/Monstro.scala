package br.edu.unifei.darksouls3

import scala.slick.driver.PostgresDriver.simple._

class Monstro(tag: Tag) extends Table[(String,Int,Int,Int,Long,String,Boolean,Int,Int,Int,Int,Float,Boolean,Boolean)](tag,"monstro"){
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

  def ressuscita = column[Boolean]("ressuscita")
  def chefe = column[Boolean]("chefe")

  def * = (nome,vida,foco,estamina,almas,especie,hollow,forca,destreza,inteligencia,fe,defesaFisica,ressuscita,chefe)
}
