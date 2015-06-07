package sbtdatabricks

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
