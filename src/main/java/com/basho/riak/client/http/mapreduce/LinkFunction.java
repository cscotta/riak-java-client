/*
 * This file is provided to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
package com.basho.riak.client.http.mapreduce;

import org.json.JSONException;
import org.json.JSONObject;

public class LinkFunction implements MapReduceFunction {
   
   private String bucket = null;
   private String tag = null;
   
   public LinkFunction(String bucket) {
      this.bucket = bucket;
   }
   
   public LinkFunction(String bucket, String tag) {
      this.bucket = bucket;
      this.tag = tag;
   }

   public JSONObject toJson() {
      try {
          JSONObject link = new JSONObject();
          link.put("bucket", this.bucket);
    
          if (this.tag != null) {
             link.put("tag", this.tag);
          }

          return link;
      } catch (JSONException e) {
          throw new RuntimeException("Can always map a string to a string");
      }
   }

}
