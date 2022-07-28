import { RmanFunctions } from './rmanFunctions';

export interface RmanPermissions {
    read: any;
    upload: any;
    write: any;
    rfid: any;
    roleid: any;
    functionId: any;
    rmanFunctions: RmanFunctions;
    enabledFlag: any;
    startDateActive: any;
    endDateActive: any
}
