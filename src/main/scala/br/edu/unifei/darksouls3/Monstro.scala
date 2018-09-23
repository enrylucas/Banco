package br.edu.unifei.darksouls3

import scala.slick.driver.PostgresDriver.simple._

class Monstro(tag: Tag) extends Table[(String,Int,Long,Boolean,Int,Int,Int,Int,Boolean,Boolean,String)](tag,"monstro"){
  val regioes = TableQuery[Regiao]

  def nome = column[String]("nome",O.PrimaryKey)
  def vida = column[Int]("vida")

  def almas = column[Long]("almas")
  def hollow = column[Boolean]("hollow")
  def ataqueFisico = column[Int]("ataqueFisico")
  def ataqueMagico = column[Int]("ataqueMagico")
  def defesaFisica = column[Int]("defesaFisica")
  def defesaMagica = column[Int]("defesaMagica")
  def ressuscita = column[Boolean]("ressuscita")
  def chefe = column[Boolean]("chefe")

  //FK
  def regiaoNome = column[String]("regiaoNome")

  def * = (nome,vida,almas,hollow,ataqueFisico,ataqueMagico,defesaFisica,defesaMagica,ressuscita,chefe,regiaoNome)
  def localizacoes = foreignKey("regiao_FK",regiaoNome,regioes)(_.nome)

}
