package br.edu.unifei.darksouls3.models

import scala.slick.driver.PostgresDriver.simple._

class Item(tag: Tag) extends Table[(String,Int,String, Option[String], Option[String])](tag,"item") {
  val humanoides = TableQuery[Humanoide]
  val regioes = TableQuery[Regiao]

  def nome = column[String]("nome",O.PrimaryKey)
  def quantidade = column[Int]("quantidade")
  def descricao = column[String]("descricao")

  //FK
  def humanoideNome = column[Option[String]]("humanoideNome")
  def regiaoNome = column[Option[String]]("regiaoNome")


  def * = (nome, quantidade, descricao, humanoideNome,regiaoNome)

  def humanoide = foreignKey("humanoide_FK",humanoideNome,humanoides)(_.nome)
  def regiao = foreignKey("regiao_FK",regiaoNome,regioes)(_.nome)

}
