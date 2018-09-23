package br.edu.unifei.darksouls3

import scala.slick.driver.PostgresDriver.simple._

class Monstro(tag: Tag) extends Table[(String,Int,Int,Int,Long,Boolean,Int,Int,Int,Int,Float,Float,Boolean,Boolean,String)](tag,"monstro"){
  val regioes = TableQuery[Regiao]

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
  def ressuscita = column[Boolean]("ressuscita")
  def chefe = column[Boolean]("chefe")

  //FK
  def regiaoNome = column[String]("regiaoNome")

  def * = (nome,vida,foco,estamina,almas,hollow,forca,destreza,inteligencia,fe,defesaFisica,defesaMagica,ressuscita,chefe,regiaoNome)
  def localizacoes = foreignKey("regiao_FK",regiaoNome,regioes)(_.nome)

}
