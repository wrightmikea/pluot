/**
 Copyright (c) 2013 Michael A. Wright.

 Licensed under the Apache License, Version 2.0 (the "License");
 you may not use this file except in compliance with the License.
 You may obtain a copy of the License at

 http://www.apache.org/licenses/LICENSE-2.0

 Unless required by applicable law or agreed to in writing, software
 distributed under the License is distributed on an "AS IS" BASIS,
 WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 See the License for the specific language governing permissions and
 limitations under the License.
 */
package com.scalablelabs.pluot.app;

import com.bazaarvoice.dropwizard.assets.AssetsBundleConfiguration;
import com.bazaarvoice.dropwizard.assets.AssetsConfiguration;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.scalablelabs.pluot.app.service.EmbeddableService;
import com.yammer.dropwizard.config.Configuration;
import com.yammer.dropwizard.config.Environment;
import com.yammer.dropwizard.json.ObjectMapperFactory;
import com.yammer.dropwizard.validation.Validator;
import org.junit.Test;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import static org.fest.assertions.Assertions.assertThat;

/**
 *
 */
public class EmbeddableServiceTest {

  final static String RUN = "run";

  @Test
  public void testEmbeddableServiceRun() throws Exception {
    Spy spy = new Spy();
    SpyService sut = spy._service;

    sut.run(spy._config, spy._env);

    assertThat(spy._config.state).isEqualTo(RUN);
    assertThat(((SpyEnv)spy._env).state).isEqualTo(RUN);
  }
}

class Spy {
  SpyConfig _config = new SpyConfig();
  Environment _env = SpyEnv.getMockEnv();
  SpyService _service = new SpyService();
}

class SpyConfig extends Configuration implements AssetsBundleConfiguration {
  @Valid
  @NotNull
  @JsonProperty
  private final AssetsConfiguration assets = new AssetsConfiguration();

  @Override
  public AssetsConfiguration getAssetsConfiguration() {
    return assets;
  }

  protected String state = null;
}

class SpyEnv extends Environment {
  private SpyEnv(String name, Configuration configuration, ObjectMapperFactory objectMapperFactory, Validator validator) {
    super(name, configuration, objectMapperFactory, validator);
  }
  public static SpyEnv getMockEnv() {
    return new SpyEnv(null, null, null, null);
  }
  protected String state = null;
}

class SpyService extends EmbeddableService<SpyConfig> {
  @Override
  public void run(SpyConfig configuration, Environment environment) throws Exception {
    if (null != configuration.getAssetsConfiguration()) {
      configuration.state = EmbeddableServiceTest.RUN;
      ((SpyEnv) environment).state = EmbeddableServiceTest.RUN;
    }
  }
}