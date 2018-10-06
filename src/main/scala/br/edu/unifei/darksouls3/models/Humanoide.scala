package br.edu.unifei.darksouls3.models

import scala.slick.driver.PostgresDriver.simple._
class Humanoide(tag: Tag) extends Table[(String,Int,Int,Int,Long,Boolean,Int,Int,Int,Int,Int,Int,Int,Int,String,Int,String)](tag,"humanoide"){
  val regioes = TableQuery[Regiao]
  val aparencias = TableQuery[Aparencia]
  val classes = TableQuery[Classe]

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
  def defesaFisica = column[Int]("defesaFisica")
  def defesaMagica = column[Int]("defesaMagica")
  def nivel = column[Int]("nivel")
  def cargaEquipamento = column[Int]("cargaEquipamento")

  //FK
  def classeNome = column[String]("classeNome")
  def idAparencia = column[Int]("idAparencia")
  def regiaoNome = column[String]("regiaoNome")

  def * = (nome,vida,foco,estamina,almas,hollow,forca,destreza,inteligencia,fe,defesaFisica,defesaMagica,nivel,cargaEquipamento,classeNome,idAparencia,regiaoNome)
  def aparencia = foreignKey("aparencia_FK",idAparencia,aparencias)(_.idVisual)

  def localizacao = foreignKey("regiao_FK",regiaoNome,regioes)(_.nome)

  def classe = foreignKey("classe_FK", classeNome, classes)(_.nome)
}
