import { MessageType } from "./messagetype";

export interface wsMessage {
    messagetype: MessageType;
    sender: string;
    content: string;
    timestamp: Date;
}