package sbtdatabricks.util

sealed trait DBCCommandStatus { def status: String }
case object DBCCommandQueued extends DBCCommandStatus { val status = "Queued" }
case object DBCCommandRunning extends DBCCommandStatus { val status = "Running" }
case object DBCCommandCancelling extends DBCCommandStatus { val status = "Cancelling" }
case object DBCCommandFinished extends DBCCommandStatus { val status = "Finished" }
case object DBCCommandCancelled extends DBCCommandStatus { val status = "Cancelled" }
case object DBCCommandError extends DBCCommandStatus { val status = "Error" }
