package br.edu.unifei.darksouls3

import scala.slick.driver.PostgresDriver.simple._

class Item(tag: Tag) extends Table[(String,Int,String)](tag,"item") {
  def nome = column[String]("nome",O.PrimaryKey)
  def quantidade = column[Int]("quantidade")
  def descricao = column[String]("descricao")

  def * = (nome, quantidade, descricao)
}
