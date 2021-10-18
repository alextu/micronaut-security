/*
 * Copyright 2017-2021 original authors
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package io.micronaut.security.token.jwt.render;

import io.micronaut.core.annotation.Internal;
import io.micronaut.security.authentication.Authentication;
import io.micronaut.security.token.render.AccessRefreshToken;

/**
 * Adapts from {@link TokenRenderer} to {@link io.micronaut.security.token.render.TokenRenderer}.
 * @author Sergio del Amo
 * @since 3.2.0
 */
@Deprecated
@Internal
public class TokenRenderAdapter implements io.micronaut.security.token.render.TokenRenderer {
    private final TokenRenderer tokenRenderer;
    public TokenRenderAdapter(TokenRenderer tokenRenderer) {
        this.tokenRenderer = tokenRenderer;
    }
    @Override
    public AccessRefreshToken render(Integer expiresIn, String accessToken, String refreshToken) {
        return new AccessRefreshTokenAdapter(tokenRenderer.render(expiresIn, accessToken, refreshToken));
    }

    @Override
    public AccessRefreshToken render(Authentication authentication, Integer expiresIn, String accessToken, String refreshToken) {
        return new AccessRefreshTokenAdapter(tokenRenderer.render(authentication, expiresIn, accessToken, refreshToken));
    }
}
