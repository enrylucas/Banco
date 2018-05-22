package br.edu.unifei.darksouls3

import scala.slick.driver.PostgresDriver.simple._

class Humanoide(tag: Tag) extends Table[(String,Int,Int,Int,Long,String,Boolean,Int,Int,Int,Int,Float, Int,Int,Int,Int,Int,Int,Float,Float,Float,Int,Int,Int)](tag,"humanoide"){
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

  def nivel = column[Int]("nivel")
  def vigor = column[Int]("vigor")
  def attunement = column[Int]("attunement")
  def resistencia = column[Int]("resistencia")
  def vitalidade = column[Int]("vitalidade")
  def sorte = column[Int]("sorte")
  def cargaEquipamento = column[Float]("cargaEquipamento")
  def equilibrio = column[Float]("equilibrio")
  def itemDescoberta = column[Int]("itemDescoberta")
  def numeroAttunement = column[Int]("numeroAttunement")
  def nivelVazio = column[Int]("nivelVazio")

  def * = (nome,vida,foco,estamina,almas,especie,hollow,forca,destreza,inteligencia,fe,defesaFisica,nivel,vigor,attunement,resistencia,vitalidade,sorte,cargaEquipamento,equilibrio,itemDescoberta,numeroAttunement,nivelVazio)
}
