package org.apache.maven.plugin.surefire.report;

/*
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
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

import org.apache.maven.surefire.api.report.StackTraceWriter;

/**
 *
 * Maintains per-thread test result state for a single test method.
 *
 * @author Qingzhou Luo
 *
 */
public class TestMethodStats
{
    private final String testClassMethodName;

    private final ReportEntryType resultType;

    private final StackTraceWriter stackTraceWriter;

    public TestMethodStats( String testClassMethodName, ReportEntryType resultType, StackTraceWriter stackTraceWriter )
    {
        this.testClassMethodName = testClassMethodName;
        this.resultType = resultType;
        this.stackTraceWriter = stackTraceWriter;
    }

    public String getTestClassMethodName()
    {
        return testClassMethodName;
    }

    public String getTestClassName()
    {
        if ( testClassMethodName.contains( "." ) )
        {
            return testClassMethodName.substring( 0, testClassMethodName.lastIndexOf( "." ) );
        }
        else
        {
            return testClassMethodName;
        }
    }

    public ReportEntryType getResultType()
    {
        return resultType;
    }

    public StackTraceWriter getStackTraceWriter()
    {
        return stackTraceWriter;
    }
}
