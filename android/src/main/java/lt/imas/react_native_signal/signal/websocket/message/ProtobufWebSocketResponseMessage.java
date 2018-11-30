package lt.imas.react_native_signal.signal.websocket.message;

/*
 * Copyright (C) 2014 Open WhisperSystems
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

import java.util.HashMap;
import java.util.Map;

import lt.imas.react_native_signal.signal.websocket.protobuf.SubProtocol;

public class ProtobufWebSocketResponseMessage implements WebSocketResponseMessage {

    private final SubProtocol.WebSocketResponseMessage message;

    public ProtobufWebSocketResponseMessage(SubProtocol.WebSocketResponseMessage message) {
        this.message = message;
    }

    @Override
    public long getRequestId() {
        return message.getId();
    }

    @Override
    public int getStatus() {
        return message.getStatus();
    }

    @Override
    public String getMessage() {
        return message.getMessage();
    }

    @Override
    public byte[] getBody() {
        if (message.getBody() != null && !message.getBody().isEmpty()) {
            return message.getBody().toByteArray();
        }
        return null;
    }

    @Override
    public Map<String, String> getHeaders() {
        Map<String, String> results = new HashMap<>();

        for (String header : message.getHeadersList()) {
            String[] tokenized = header.split(":");

            if (tokenized.length == 2 && tokenized[0] != null && tokenized[1] != null) {
                results.put(tokenized[0].trim().toLowerCase(), tokenized[1].trim());
            }
        }

        return results;
    }
}