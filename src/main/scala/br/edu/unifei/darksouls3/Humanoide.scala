package br.edu.unifei.darksouls3

import scala.slick.driver.PostgresDriver.simple._

class Humanoide(tag: Tag) extends Table[(String,Int,Int,Int,Long,Boolean,Int,Int,Int,Int,Float,Float,Int,Float)](tag,"humanoide"){
  def nome = column[String]("nome",O.PrimaryKey)
  def vida = column[Int]("vida")
  def foco = column[Int]("foco")
  def estamina = column[Int]("estamina")
  def almas = column[Long]("almas")
  def hollow = column[Boolean]("hollow")
  def forca = column[Int]("forca")
  def destreza = column[Int]("destreza")
  def inteligencia = column[Int]("inteligencia")
  def fe = column[Int]("fe")
  def defesaFisica = column[Float]("defesaFisica")
  def defesaMagica = column[Float]("defesaMagica")
  def nivel = column[Int]("nivel")
  def cargaEquipamento = column[Float]("cargaEquipamento")

  def * = (nome,vida,foco,estamina,almas,hollow,forca,destreza,inteligencia,fe,defesaFisica,defesaMagica,nivel,cargaEquipamento)
}
