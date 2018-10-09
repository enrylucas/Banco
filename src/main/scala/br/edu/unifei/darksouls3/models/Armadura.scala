package br.edu.unifei.darksouls3.models

import scala.slick.driver.PostgresDriver.simple._


class Armadura(tag: Tag) extends Table[(String,Int,Int,Int,Int,Boolean, Categoria.Value, String)](tag,"armadura"){
  val humanoides = TableQuery[Humanoide]

  def nome = column[String]("nome",O.PrimaryKey)
  def peso = column[Int]("peso")
  def durabilidade = column[Int]("durabilidade")
  def defesaFisica = column[Int]("defesaFisica")
  def defesaMagica = column[Int]("defesaMagica")
  def quebrado = column[Boolean]("quebrado")
  def categoria = column[Categoria.Value]("categoria")

  def humanoideNome = column[String]("humanoideNome")

  def * = (nome, peso, durabilidade, defesaFisica, defesaMagica, quebrado, categoria, humanoideNome)

  def humanoide = foreignKey("humanoide_FK",humanoideNome,humanoides)(_.nome)




}
