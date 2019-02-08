//
//  MessageDTO.swift
//  PillarWalletSigal
//
//  Created by Mantas on 06/07/2018.
//  Copyright © 2018 Pillar. All rights reserved.
//

import UIKit

class MessageDTO: NSObject {
    
    var dictionary = [String : Any]()
    
    init(dictionary: [String : Any]) {
        super.init()
        
        self.dictionary = dictionary
    }
    
    func messageData() -> Data? {
        if (!self.legacyMessage.isEmpty) {
            return Data(base64Encoded: self.legacyMessage)
        }
        return Data(base64Encoded: self.message)
    }
    
    func getMessageDataType() -> String {
        if (!self.legacyMessage.isEmpty) {
            return "legacy message"
        }
        return "regular message"
    }
    
    var type: Int {
        get {
            return self.dictionary["type"] as? Int ?? 0
        }
    }
    
    var relay: String {
        get {
            return self.dictionary["relay"] as? String ?? ""
        }
    }
    
    var timestamp: Int64 {
        get {
            return self.dictionary["timestamp"] as? Int64 ?? 0
        }
    }
    
    var source: String {
        get {
            return self.dictionary["source"] as? String ?? ""
        }
    }
    
    var sourceDevice: Int {
        get {
            return self.dictionary["sourceDevice"] as? Int ?? 0
        }
    }
    
    var content: String? {
        get {
            return self.dictionary["source"] as? String
        }
    }
    
    var message: String {
        get {
            return self.dictionary["message"] as? String ?? ""
        }
    }
    
    var legacyMessage: String {
        get {
            return self.dictionary["legacyMessage"] as? String ?? ""
        }
    }

    var tag: String {
        get {
            return self.dictionary["tag"] as? String ?? ""
        }
    }
}
