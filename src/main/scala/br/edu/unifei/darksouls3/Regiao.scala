package br.edu.unifei.darksouls3

import scala.slick.driver.PostgresDriver.simple._

class Regiao(tag: Tag) extends Table[(String,Int)](tag,"regiao") {
  //def id = column[Int]("id")
  def nome = column[String]("nome",O.PrimaryKey)
  def quantidadeFogueira = column[Int]("quantidadeFogueira")
  def * = (nome,quantidadeFogueira)
}
