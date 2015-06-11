/*
 * Copyright 2015 Databricks
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package sbtdatabricks

import org.apache.http.entity.StringEntity
import com.fasterxml.jackson.databind.ObjectMapper

import sbtdatabricks.DatabricksPlugin.autoImport.{DBCExecutionLanguage, DBCScala, DBCPython, DBCSQL}
import DBApiEndpoints._

private[sbtdatabricks] case class CreateContextRequestV1(
  language: String,
  clusterId: String
)

private[sbtdatabricks] case class DestroyContextRequestV1(
  clusterId: String,
  contextId: String
)

private[sbtdatabricks] case class CancelCommandRequestV1(
  clusterId: String,
  contextId: String,
  commandId: String
)

private[sbtdatabricks] trait PostInputs {
  def initialMessage: String
  val requestCC: Product
  val dbAPIEndPoint: String
  def createForm(mapper: ObjectMapper): StringEntity = {
   new StringEntity(mapper.writeValueAsString(requestCC))
  }
}

private[sbtdatabricks] case class CreateContextInputV1(
  language: DBCExecutionLanguage,
  cluster: Cluster
) extends PostInputs {
  def initialMessage: String = {
    s"Creating '${language.is}' execution context on cluster '${cluster.name}'"
  }

  val requestCC = CreateContextRequestV1(language.is, cluster.id)

  val dbAPIEndPoint = CONTEXT_CREATE
}

private[sbtdatabricks] case class DestroyContextInputV1(
  cluster: Cluster,
  contextId: ContextId
) extends PostInputs {
  def initialMessage: String = {
    s"Terminating execution context '${contextId.id}' on cluster '${cluster.name}'"
  }

  val requestCC = DestroyContextRequestV1(cluster.id, contextId.id)

  val dbAPIEndPoint = CONTEXT_DESTROY
}

private[sbtdatabricks] case class CancelCommandInputV1(
  cluster: Cluster,
  contextId: ContextId,
  commandId: CommandId
) extends PostInputs {
  def initialMessage: String = {
    s"Cancelling command '${commandId.id}' on cluster '${cluster.name}'"
  }

  val requestCC = CancelCommandRequestV1(cluster.id, contextId.id, commandId.id)

  val dbAPIEndPoint = COMMAND_CANCEL
}
