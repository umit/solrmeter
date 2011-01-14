/**
 * Copyright Linebee LLC
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
package com.linebee.solrmeter.mock;

import java.net.MalformedURLException;

import org.apache.solr.client.solrj.impl.CommonsHttpSolrServer;

import com.linebee.solrmeter.model.executor.UpdateExecutorRandomImpl;

public class UpdateExecutorSpy extends UpdateExecutorRandomImpl {

	private SolrServerMock serverMock;
	
	public UpdateExecutorSpy() {
		super(null);
		try {
			serverMock = new SolrServerMock();
		} catch (MalformedURLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public synchronized CommonsHttpSolrServer getSolrServer() {
		return serverMock;
	}
}