/**
 * Copyright Linebee. www.linebee.com
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
import java.util.LinkedList;

import org.apache.solr.client.solrj.impl.CommonsHttpSolrServer;

import com.linebee.solrmeter.model.OptimizeExecutor;
import com.linebee.solrmeter.model.OptimizeStatistic;

public class OptimizeExecutorSpy extends OptimizeExecutor {

	public OptimizeExecutorSpy() throws MalformedURLException {
		optimizeObservers = new LinkedList<OptimizeStatistic>();
		this.server = new SolrServerMock();
	}
	
	@Override
	public void prepare() {
		super.prepare();
		try {
			this.server = new SolrServerMock();
		} catch (MalformedURLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public CommonsHttpSolrServer getServer() {
		return server;
	}
	public void setServer(CommonsHttpSolrServer server) {
		this.server = server;
	}
	
	
}