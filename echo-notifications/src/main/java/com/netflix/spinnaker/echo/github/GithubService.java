/*
 * Copyright 2018 Schibsted ASA
 *
 * Licensed under the Apache License, Version 2.0 (the "License")
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.netflix.spinnaker.echo.github;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface GithubService {
  @POST("repos/{repo}/statuses/{sha}")
  Call<Response<ResponseBody>> updateCheck(
      @Header("Authorization") String token,
      @Path(value = "repo", encoded = true) String repo,
      @Path("sha") String sha,
      @Body GithubStatus status);

  @GET("repos/{repo}/commits/{sha}")
  Call<GithubCommit> getCommit(
      @Header("Authorization") String token,
      @Path(value = "repo", encoded = true) String repo,
      @Path("sha") String sha);
}
