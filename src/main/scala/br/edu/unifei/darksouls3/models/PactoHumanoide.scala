package br.edu.unifei.darksouls3.models

import scala.slick.driver.PostgresDriver.simple._

class PactoHumanoide (tag: Tag) extends Table[(String,String)](tag,"pactoHumanoide"){
  val pactos = TableQuery[Pacto]
  val humanoides = TableQuery[Humanoide]

  def pactoNome = column[String]("pactoNome")
  def humanoideNome = column[String]("humanoideNome")

  def * = (pactoNome,humanoideNome)
  def pk = primaryKey("primaryKey",(pactoNome,humanoideNome))

  def pacFK = foreignKey("pacto_FK", pactoNome, pactos)(_.nome)
  def humFK = foreignKey("humanoide_FK", humanoideNome, humanoides)(_.nome)


}
