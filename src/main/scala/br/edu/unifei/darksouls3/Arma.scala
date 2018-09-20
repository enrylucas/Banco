package br.edu.unifei.darksouls3

import scala.slick.driver.PostgresDriver.simple._


class Arma(tag: Tag) extends Table[(String,Float,Float,Float,Float,Boolean)](tag,"arma"){
  def nome = column[String]("nome",O.PrimaryKey)
  def peso = column[Float]("peso")
  def durabilidade = column[Float]("durabilidade")
  def ataqueFisico = column[Float]("ataqueFisico")
  def ataqueMagico = column[Float]("ataqueMagico")
  def quebrado = column[Boolean]("quebrado")

  def * = (nome, peso, durabilidade, ataqueFisico, ataqueMagico, quebrado)


}