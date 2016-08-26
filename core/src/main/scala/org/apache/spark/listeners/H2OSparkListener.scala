/*
* Licensed to the Apache Software Foundation (ASF) under one or more
* contributor license agreements.  See the NOTICE file distributed with
* this work for additional information regarding copyright ownership.
* The ASF licenses this file to You under the Apache License, Version 2.0
* (the "License"); you may not use this file except in compliance with
* the License.  You may obtain a copy of the License at
*
*    http://www.apache.org/licenses/LICENSE-2.0
*
* Unless required by applicable law or agreed to in writing, software
* distributed under the License is distributed on an "AS IS" BASIS,
* WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
* See the License for the specific language governing permissions and
* limitations under the License.
*/
package org.apache.spark.listeners

import org.apache.spark.scheduler.{SparkListener, SparkListenerEvent, SparkListenerExecutorAdded}

trait H2OSparkListener extends SparkListener {

  // Fix for CDH 5.7 spark version which already implements some Spark 2.0 features
  def onOtherEvent(event: SparkListenerEvent) { }

}

class ExecutorAddNotSupportedListener extends H2OSparkListener {

  override def onExecutorAdded(executorAdded: SparkListenerExecutorAdded): Unit = {
    throw new IllegalArgumentException("Executor without H2O instance discovered, killing the cloud!")
  }

}