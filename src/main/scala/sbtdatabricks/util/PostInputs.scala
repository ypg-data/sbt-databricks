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

import sbtdatabricks.util.requests._
import DBApiEndpoints._

private[sbtdatabricks] trait PostInputs {
  def initialMessage: String
  val requestCC: DBApiRequest
  val dbAPIEndPoint: String
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
    s"Terminating execution context on cluster '${cluster.name}'"
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
    s"Cancelling command on cluster '${cluster.name}'"
  }

  val requestCC = CancelCommandRequestV1(cluster.id, contextId.id, commandId.id)

  val dbAPIEndPoint = COMMAND_CANCEL
}

private[sbtdatabricks] case class LibraryAttachInputV1(
  library: UploadedLibrary,
  cluster: Cluster
) extends PostInputs {
  def initialMessage: String = {
    s"Attaching ${library.name} to cluster '${cluster.name}'"
  }

  val requestCC = LibraryAttachRequestV1(library.id, cluster.id)

  val dbAPIEndPoint = LIBRARY_ATTACH
}

private[sbtdatabricks] case class RestartClusterInputV1(
  cluster: Cluster
) extends PostInputs {
  def initialMessage: String = {
    s"Restarting cluster: ${cluster.name}"
  }

  val requestCC = RestartClusterRequestV1(cluster.id)

  val dbAPIEndPoint = CLUSTER_RESTART
}

private[sbtdatabricks] case class CreateClusterInputV1(
  name: String,
  memoryGB: Integer,
  useSpot: Boolean
) extends PostInputs {
  def initialMessage: String = {
    s"Creating cluster: ${name}"
  }

  val requestCC = CreateClusterRequestV1(name, memoryGB, useSpot)

  val dbAPIEndPoint = CLUSTER_CREATE
}

private[sbtdatabricks] case class ResizeClusterInputV1(
  cluster: Cluster,
  memoryGB: Integer
) extends PostInputs {
  def initialMessage: String = {
    s"Resizing cluster: ${cluster.name}"
  }

  val requestCC = ResizeClusterRequestV1(cluster.id, memoryGB)

  val dbAPIEndPoint = CLUSTER_RESIZE
}

private[sbtdatabricks] case class DeleteClusterInputV1(
  cluster: Cluster
) extends PostInputs {
  def initialMessage: String = {
    s"Deleting cluster: ${cluster.name}"
  }

  val requestCC = DeleteClusterRequestV1(cluster.id)

  val dbAPIEndPoint = CLUSTER_DELETE
}
