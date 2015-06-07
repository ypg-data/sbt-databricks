package sbtdatabricks

private[sbtdatabricks] sealed trait DBCCommandStatus { def status: String }
private[sbtdatabricks] case object DBCCommandQueued extends DBCCommandStatus { val status = "Queued" }
private[sbtdatabricks] case object DBCCommandRunning extends DBCCommandStatus { val status = "Running" }
private[sbtdatabricks] case object DBCCommandCancelling extends DBCCommandStatus { val status = "Cancelling" }
private[sbtdatabricks] case object DBCCommandFinished extends DBCCommandStatus { val status = "Finished" }
private[sbtdatabricks] case object DBCCommandCancelled extends DBCCommandStatus { val status = "Cancelled" }
private[sbtdatabricks] case object DBCCommandError extends DBCCommandStatus { val status = "Error" }
