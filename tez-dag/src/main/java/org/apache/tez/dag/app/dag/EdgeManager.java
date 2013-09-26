/**
* Licensed to the Apache Software Foundation (ASF) under one
* or more contributor license agreements.  See the NOTICE file
* distributed with this work for additional information
* regarding copyright ownership.  The ASF licenses this file
* to you under the Apache License, Version 2.0 (the
* "License"); you may not use this file except in compliance
* with the License.  You may obtain a copy of the License at
*
*     http://www.apache.org/licenses/LICENSE-2.0
*
* Unless required by applicable law or agreed to in writing, software
* distributed under the License is distributed on an "AS IS" BASIS,
* WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
* See the License for the specific language governing permissions and
* limitations under the License.
*/

package org.apache.tez.dag.app.dag;

import java.util.List;

import org.apache.tez.runtime.api.events.DataMovementEvent;
import org.apache.tez.runtime.api.events.InputFailedEvent;
import org.apache.tez.runtime.api.events.InputReadErrorEvent;

public abstract class EdgeManager {
  
  public abstract int getNumDestinationTaskInputs(int numSourceTasks, 
      int destinationTaskIndex);

  public abstract int getNumSourceTaskOutputs(int numDestinationTasks, 
      int sourceTaskIndex);
  
  /**
   * Return the destination task indeces to which to send the event
   */
  public abstract void routeEventToDestinationTasks(DataMovementEvent event,
      int sourceTaskIndex, int numDestinationTasks, List<Integer> taskIndices);
  
  public abstract void routeEventToDestinationTasks(InputFailedEvent event,
      int sourceTaskIndex, int numDestinationTasks, List<Integer> taskIndices);

  public abstract int getDestinationConsumerTaskNumber(int sourceTaskIndex, int numDestTasks);
  
  /**
   * Return the source task index to which to send the event
   */
  public abstract int routeEventToSourceTasks(int destinationTaskIndex,
      InputReadErrorEvent event);
  
}