package br.edu.unifei.darksouls3.models

import scala.slick.driver.PostgresDriver.simple._

class Pacto(tag: Tag) extends Table[(String,String)](tag,"pacto"){
  def nome = column[String]("nome",O.PrimaryKey)
  def itemPacto = column[String]("itemPacto")


  def * = (nome,itemPacto)
}
